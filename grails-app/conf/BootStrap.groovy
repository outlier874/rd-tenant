import commerce.Store

class BootStrap {

    def init = { servletContext ->
        print("*************Star boot strap*********")
        def store = new Store(name:"name",address: "address").save()
        print("BootStrap is call")
    }
    def destroy = {
    }
}
