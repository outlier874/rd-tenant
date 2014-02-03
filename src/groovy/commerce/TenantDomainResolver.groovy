package commerce

import grails.plugin.multitenant.core.resolve.TenantResolver

import javax.servlet.http.HttpServletRequest

class TenantDomainResolver implements TenantResolver {

    @Override
    public Integer resolve(HttpServletRequest request) {

        String domain = request.getParameter("domain")

        print("resolver is triggered")

        if(domain!=null){
           Merchant merchant =  Merchant.findByDomain(domain)
           return merchant?.id;
        }


        return 2
    }

}