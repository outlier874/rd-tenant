package commerce

import grails.plugin.multitenant.core.Tenant

/**
 *
 */
class Merchant implements Tenant{

    String name

    String domain

    static constraints = {
    }
    Integer tenantId() {
        id
    }

}
