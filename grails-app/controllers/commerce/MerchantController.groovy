package commerce



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MerchantController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Merchant.list(params), model:[merchantInstanceCount: Merchant.count()]
    }

    def show(Merchant merchantInstance) {
        respond merchantInstance
    }

    def create() {
        respond new Merchant(params)
    }

    @Transactional
    def save(Merchant merchantInstance) {
        if (merchantInstance == null) {
            notFound()
            return
        }

        if (merchantInstance.hasErrors()) {
            respond merchantInstance.errors, view:'create'
            return
        }

        merchantInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'merchantInstance.label', default: 'Merchant'), merchantInstance.id])
                redirect merchantInstance
            }
            '*' { respond merchantInstance, [status: CREATED] }
        }
    }

    def edit(Merchant merchantInstance) {
        respond merchantInstance
    }

    @Transactional
    def update(Merchant merchantInstance) {
        if (merchantInstance == null) {
            notFound()
            return
        }

        if (merchantInstance.hasErrors()) {
            respond merchantInstance.errors, view:'edit'
            return
        }

        merchantInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Merchant.label', default: 'Merchant'), merchantInstance.id])
                redirect merchantInstance
            }
            '*'{ respond merchantInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Merchant merchantInstance) {

        if (merchantInstance == null) {
            notFound()
            return
        }

        merchantInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Merchant.label', default: 'Merchant'), merchantInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'merchantInstance.label', default: 'Merchant'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
