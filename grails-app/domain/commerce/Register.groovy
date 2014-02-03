package commerce

import grails.plugin.multitenant.core.annotation.MultiTenant


@MultiTenant
class Register {

    String code

    Store store

    static constraints = {
    }
}
