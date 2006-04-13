/*
 * Copyright 2005-2006 J�r�me LOUVEL
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the "License").  You may not use this file except
 * in compliance with the License.
 *
 * You can obtain a copy of the license at
 * http://www.opensource.org/licenses/cddl1.txt
 * See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * HEADER in each file and include the License file at
 * http://www.opensource.org/licenses/cddl1.txt
 * If applicable, add the following below this CDDL
 * HEADER, with the fields enclosed by brackets "[]"
 * replaced with your own identifying information:
 * Portions Copyright [yyyy] [name of copyright owner]
 */

package com.noelios.restlet.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.RestletCall;
import org.restlet.Restlet;
import org.restlet.component.Component;
import org.restlet.data.Statuses;

/**
 * Restlet target used for Maplet or Chainlet attachments.
 */
public class RestletTarget
{
   /** Obtain a suitable logger. */
   private static Logger logger = Logger.getLogger("com.noelios.restlet.util.UniformTarget");

   /** The handler interface. */
   protected Restlet handler;

   /** The handler class. */
   protected Class<? extends Restlet> handlerClass;

   /** The handler constructor. */
   protected Constructor handlerConstructor;

   /** The container class to set in the constructor. */
   protected Class containerClass;

   /** Indicates if the parent component can be set in the constructor. */
   protected boolean setParent;

   /**
    * Constructor.
    * @param handler The handler interface.
    */
   public RestletTarget(Restlet handler)
   {
      this.handler = handler;
      this.handlerClass = null;
      this.handlerConstructor = null;
      this.setParent = false;
   }

   /**
    * Constructor.
    * @param handlerClass The handler class.
    */
   public RestletTarget(Class<? extends Restlet> handlerClass)
   {
      this.handler = null;
      this.handlerClass = handlerClass;
      this.setParent = false;

      // Try to find a constructor that accepts a RestletContainer parameter
      Constructor[] constructors = handlerClass.getConstructors();
      Class[] parameters;

      for(int i = 0; (this.handlerConstructor == null) && (i < constructors.length); i++)
      {
         parameters = constructors[i].getParameterTypes();

         if(parameters.length == 1)
         {
            if(Component.class.isAssignableFrom(parameters[0]))
            {
               this.handlerConstructor = constructors[i];
               this.setParent = true;
            }
         }
      }

      if(this.handlerConstructor == null)
      {
         // Try to find an empty constructor
         try
         {
            this.handlerConstructor = handlerClass.getConstructor(new Class[]{});
         }
         catch(NoSuchMethodException nsme)
         {
         }
      }
   }

   /**
    * Handles an uniform call.
    * @param call The call to handle.
    * @param parent The parent component.
    */
   public void handle(RestletCall call, Component parent)
   {
      // Find and prepare the call handler
      Restlet handler = null;

      try
      {
         if(getHandler() != null)
         {
            handler = getHandler();
         }
         else if(isSetParent())
         {
            handler = (Restlet)getHandlerConstructor().newInstance(parent);
         }
         else
         {
            handler = (Restlet)getHandlerClass().newInstance();
         }
      }
      catch(InstantiationException ie)
      {
         call.setStatus(Statuses.SERVER_ERROR_INTERNAL);
         logger.log(Level.SEVERE, "Handler can't be instantiated", ie);
      }
      catch(IllegalAccessException iae)
      {
         call.setStatus(Statuses.SERVER_ERROR_INTERNAL);
         logger.log(Level.SEVERE, "Handler can't be accessed", iae);
      }
      catch(InvocationTargetException ite)
      {
         call.setStatus(Statuses.SERVER_ERROR_INTERNAL);
         logger.log(Level.SEVERE, "Handler can't be invoked", ite);
      }

      if(handler != null)
      {
         // Check if the handler needs to be started
         if(handler.isStopped()) 
         {
            try
            {
               handler.start();
            }
            catch(Exception e)
            {
               call.setStatus(Statuses.SERVER_ERROR_INTERNAL);
               logger.log(Level.SEVERE, "Handler can't be started", e);
            }
         }
         
         // Handle the call
         handler.handle(call);
      }
      else
      {
         call.setStatus(Statuses.SERVER_ERROR_INTERNAL);
         logger.log(Level.WARNING, "Handler can't be invoked");
      }
   }
   /**
    * Returns the handler instance.
    * @return The handler instance.
    */
   public Restlet getHandler()
   {
      return this.handler;
   }

   /**
    * Returns the handler class.
    * @return The handler class.
    */
   public Class<? extends Restlet> getHandlerClass()
   {
      return this.handlerClass;
   }

   /**
    * Returns the handler constructor.
    * @return The handler constructor.
    */
   public Constructor getHandlerConstructor()
   {
      return this.handlerConstructor;
   }

   /**
    * Returns the container class.
    * @return The container class.
    */
   public Class getContainerClass()
   {
      return this.containerClass;
   }

   /**
    * Indicates if the parent component can be set in the constructor.
    * @return True if the parent component can be set in the constructor.
    */
   public boolean isSetParent()
   {
      return this.setParent;
   }

}
