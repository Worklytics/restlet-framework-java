/**
 * Copyright 2005-2014 Restlet
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: Apache 2.0 or LGPL 3.0 or LGPL 2.1 or CDDL 1.0 or EPL
 * 1.0 (the "Licenses"). You can select the license that you prefer but you may
 * not use this file except in compliance with one of these Licenses.
 * 
 * You can obtain a copy of the Apache 2.0 license at
 * http://www.opensource.org/licenses/apache-2.0
 * 
 * You can obtain a copy of the LGPL 3.0 license at
 * http://www.opensource.org/licenses/lgpl-3.0
 * 
 * You can obtain a copy of the LGPL 2.1 license at
 * http://www.opensource.org/licenses/lgpl-2.1
 * 
 * You can obtain a copy of the CDDL 1.0 license at
 * http://www.opensource.org/licenses/cddl1
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://restlet.com/products/restlet-framework
 * 
 * Restlet is a registered trademark of Restlet S.A.S.
 */

package org.restlet.test.ext.odata.deepexpand.model;


import java.util.List;

import org.restlet.test.ext.odata.deepexpand.model.CoOp;
import org.restlet.test.ext.odata.deepexpand.model.JobPartSpecialPayable;
import org.restlet.test.ext.odata.deepexpand.model.JobPostingPartSpecialPayable;
import org.restlet.test.ext.odata.deepexpand.model.Payment;

/**
* Generated by the generator tool for the OData extension for the Restlet framework.<br>
*
* @see <a href="http://praktiki.metal.ntua.gr/CoopOData/CoopOData.svc/$metadata">Metadata of the target OData service</a>
*
*/
public class FinancialSource {

    private String code;
    private String description;
    private int id;
    private String name;
    private Tracking tracking;
    private List<CoOp> coOps;
    private List<JobPartSpecialPayable> jobPartSpecialPayables;
    private List<JobPostingPartSpecialPayable> jobPostingPartSpecialPayables;
    private List<Payment> payments;

    /**
     * Constructor without parameter.
     * 
     */
    public FinancialSource() {
        super();
    }

    /**
     * Constructor.
     * 
     * @param id
     *            The identifiant value of the entity.
     */
    public FinancialSource(int id) {
        this();
        this.id = id;
    }

   /**
    * Returns the value of the "code" attribute.
    *
    * @return The value of the "code" attribute.
    */
   public String getCode() {
      return code;
   }
   /**
    * Returns the value of the "description" attribute.
    *
    * @return The value of the "description" attribute.
    */
   public String getDescription() {
      return description;
   }
   /**
    * Returns the value of the "id" attribute.
    *
    * @return The value of the "id" attribute.
    */
   public int getId() {
      return id;
   }
   /**
    * Returns the value of the "name" attribute.
    *
    * @return The value of the "name" attribute.
    */
   public String getName() {
      return name;
   }
   /**
    * Returns the value of the "tracking" attribute.
    *
    * @return The value of the "tracking" attribute.
    */
   public Tracking getTracking() {
      return tracking;
   }
   /**
    * Returns the value of the "coOps" attribute.
    *
    * @return The value of the "coOps" attribute.
    */
   public List<CoOp> getCoOps() {
      return coOps;
   }
   
   /**
    * Returns the value of the "jobPartSpecialPayables" attribute.
    *
    * @return The value of the "jobPartSpecialPayables" attribute.
    */
   public List<JobPartSpecialPayable> getJobPartSpecialPayables() {
      return jobPartSpecialPayables;
   }
   
   /**
    * Returns the value of the "jobPostingPartSpecialPayables" attribute.
    *
    * @return The value of the "jobPostingPartSpecialPayables" attribute.
    */
   public List<JobPostingPartSpecialPayable> getJobPostingPartSpecialPayables() {
      return jobPostingPartSpecialPayables;
   }
   
   /**
    * Returns the value of the "payments" attribute.
    *
    * @return The value of the "payments" attribute.
    */
   public List<Payment> getPayments() {
      return payments;
   }
   
   /**
    * Sets the value of the "code" attribute.
    *
    * @param code
    *     The value of the "code" attribute.
    */
   public void setCode(String code) {
      this.code = code;
   }
   /**
    * Sets the value of the "description" attribute.
    *
    * @param description
    *     The value of the "description" attribute.
    */
   public void setDescription(String description) {
      this.description = description;
   }
   /**
    * Sets the value of the "id" attribute.
    *
    * @param id
    *     The value of the "id" attribute.
    */
   public void setId(int id) {
      this.id = id;
   }
   /**
    * Sets the value of the "name" attribute.
    *
    * @param name
    *     The value of the "name" attribute.
    */
   public void setName(String name) {
      this.name = name;
   }
   /**
    * Sets the value of the "tracking" attribute.
    *
    * @param tracking
    *     The value of the "tracking" attribute.
    */
   public void setTracking(Tracking tracking) {
      this.tracking = tracking;
   }
   
   /**
    * Sets the value of the "coOps" attribute.
    *
    * @param coOps"
    *     The value of the "coOps" attribute.
    */
   public void setCoOps(List<CoOp> coOps) {
      this.coOps = coOps;
   }

   /**
    * Sets the value of the "jobPartSpecialPayables" attribute.
    *
    * @param jobPartSpecialPayables"
    *     The value of the "jobPartSpecialPayables" attribute.
    */
   public void setJobPartSpecialPayables(List<JobPartSpecialPayable> jobPartSpecialPayables) {
      this.jobPartSpecialPayables = jobPartSpecialPayables;
   }

   /**
    * Sets the value of the "jobPostingPartSpecialPayables" attribute.
    *
    * @param jobPostingPartSpecialPayables"
    *     The value of the "jobPostingPartSpecialPayables" attribute.
    */
   public void setJobPostingPartSpecialPayables(List<JobPostingPartSpecialPayable> jobPostingPartSpecialPayables) {
      this.jobPostingPartSpecialPayables = jobPostingPartSpecialPayables;
   }

   /**
    * Sets the value of the "payments" attribute.
    *
    * @param payments"
    *     The value of the "payments" attribute.
    */
   public void setPayments(List<Payment> payments) {
      this.payments = payments;
   }

}