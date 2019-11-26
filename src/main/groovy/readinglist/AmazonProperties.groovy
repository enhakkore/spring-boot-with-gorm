package readinglist

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@Configuration
class AmazonProperties {

    String associateId

    def getAssociateId() {
        associateId
    }
}
