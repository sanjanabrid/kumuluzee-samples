/*
 *  Copyright (c) 2014-2017 Kumuluz and/or its affiliates
 *  and other contributors as indicated by the @author tags and
 *  the contributor list.
 *
 *  Licensed under the MIT License (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  https://opensource.org/licenses/MIT
 *
 *  The software is provided "AS IS", WITHOUT WARRANTY OF ANY KIND, express or
 *  implied, including but not limited to the warranties of merchantability,
 *  fitness for a particular purpose and noninfringement. in no event shall the
 *  authors or copyright holders be liable for any claim, damages or other
 *  liability, whether in an action of contract, tort or otherwise, arising from,
 *  out of or in connection with the software or the use or other dealings in the
 *  software. See the License for the specific language governing permissions and
 *  limitations under the License.
*/
package com.kumuluz.ee.samples.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Benjamin on 26. apr. 2017.
 */
@ManagedBean
@SessionScoped
public class CustomerBean implements Serializable {

    private String id;
    private String firstName;
    private String lastName;

    public CustomerBean() {
    }

    public CustomerBean(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addCustomer() {
        Customer customer = new Customer();
        customer.setId(this.getId());
        customer.setFirstName(this.getFirstName());
        customer.setLastName(this.getLastName());

        Database.addCustomer(customer);

        this.setId(null);
        this.setFirstName(null);
        this.setLastName(null);
    }

    public List<Customer> getCustomers()
    {
        return Database.getCustomers();
    }

    @Override
    public String toString() {
        return "Customer {\n" +
                "  id='" + id + "',\n" +
                "  firstName='" + firstName + "',\n" +
                "  lastName='" + lastName + "'\n" +
                "}";
    }
}
