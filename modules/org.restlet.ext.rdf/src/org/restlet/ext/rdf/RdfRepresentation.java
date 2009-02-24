/**
 * Copyright 2005-2009 Noelios Technologies.
 * 
 * The contents of this file are subject to the terms of the following open
 * source licenses: LGPL 3.0 or LGPL 2.1 or CDDL 1.0 (the "Licenses"). You can
 * select the license that you prefer but you may not use this file except in
 * compliance with one of these Licenses.
 * 
 * You can obtain a copy of the LGPL 3.0 license at
 * http://www.gnu.org/licenses/lgpl-3.0.html
 * 
 * You can obtain a copy of the LGPL 2.1 license at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 * 
 * You can obtain a copy of the CDDL 1.0 license at
 * http://www.sun.com/cddl/cddl.html
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://www.noelios.com/products/restlet-engine
 * 
 * Restlet is a registered trademark of Noelios Technologies.
 */

package org.restlet.ext.rdf;

import java.io.IOException;
import java.io.OutputStream;

import org.restlet.representation.OutputRepresentation;
import org.restlet.representation.Representation;

/**
 * Base of all RDF representation classes. It knows how to serialize and
 * deserialize a {@link Graph}.
 * 
 * @author Jerome Louvel
 */
public abstract class RdfRepresentation extends OutputRepresentation {

    private Graph graph;

    public RdfRepresentation(Graph linkSet) {
        super(null);
        this.graph = linkSet;
    }

    /**
     * Constructor that parsed a given RDF representation into a link set.
     * 
     * @param rdfRepresentation
     *            The RDF representation to parse.
     * @param linkSet
     *            The link set to update.
     * @throws IOException
     */
    public RdfRepresentation(Representation rdfRepresentation, Graph linkSet)
            throws IOException {
        this(linkSet);
        // Parsing goes here.
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph linkSet) {
        this.graph = linkSet;
    }

    @Override
    public void write(OutputStream outputStream) throws IOException {
    }

}
