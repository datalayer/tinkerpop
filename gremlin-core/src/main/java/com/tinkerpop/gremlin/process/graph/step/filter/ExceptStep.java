package com.tinkerpop.gremlin.process.graph.step.filter;

import com.tinkerpop.gremlin.process.Traversal;
import com.tinkerpop.gremlin.process.graph.marker.Reversible;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class ExceptStep<S> extends FilterStep<S> implements Reversible {

    public ExceptStep(final Traversal traversal, final String variable) {
        super(traversal);
        final Object exceptObject = this.traversal.memory().getOrCreate(variable, HashSet::new);
        if (exceptObject instanceof Collection)
            this.setPredicate(traverser -> !((Collection) exceptObject).contains(traverser.get()));
        else
            this.setPredicate(traverser -> !exceptObject.equals(traverser.get()));
    }

    public ExceptStep(final Traversal traversal, final Collection<S> exceptionCollection) {
        super(traversal);
        this.setPredicate(traverser -> !exceptionCollection.contains(traverser.get()));
    }

    public ExceptStep(final Traversal traversal, final S exceptionObject) {
        super(traversal);
        this.setPredicate(traverser -> !exceptionObject.equals(traverser.get()));
    }
}
