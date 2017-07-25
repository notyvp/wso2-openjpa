/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */
package org.apache.openjpa.persistence.jdbc.maps.m2mmapex4;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MEX4Division")
public class Division {
    @Id
    int id;

    String name;
    
    @OneToMany(mappedBy="division")
    Collection<Office> offices = new ArrayList();
    
    public Collection<Office> getOffices() {
        return offices;
    }

    public void setOffices(Collection<Office> offices) {
        this.offices = offices;
    }

    public void addOffice(Office office) {
        offices.add(office);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Division)) return false;
        Division other = (Division) o;
        if (name.equals(other.name) &&
                id == other.id)
            return true;
        return false;
    }

    public int hashCode() {
        int ret = 0;
        ret = ret * 31 + name.hashCode();
        ret = ret *31 + id;
        return ret;
    }        
}
