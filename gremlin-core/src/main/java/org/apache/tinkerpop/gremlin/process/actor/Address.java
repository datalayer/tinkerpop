/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.tinkerpop.gremlin.process.actor;

import java.io.Serializable;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public abstract class Address implements Serializable {

    private final String location;

    public Address(final String location) {
        this.location = location;
    }

    public String location() {
        return this.location;
    }

    @Override
    public boolean equals(final Object other) {
        return other instanceof Address && ((Address) other).location.equals(this.location);
    }

    @Override
    public int hashCode() {
        return this.location.hashCode();
    }

    @Override
    public String toString() {
        return this.location();
    }

    public static final class Master extends Address {

        public Master(final String location) {
            super(location);
        }

    }

    public static final class Worker extends Address {

        public Worker(final String location) {
            super(location);
        }

    }
}