package de.zalando.zally.rule

import de.zalando.zally.dto.ViolationType
import io.swagger.models.Scheme
import io.swagger.models.Swagger
import org.springframework.stereotype.Component

@Component
class SecureWithOAuth2Rule : SwaggerRule() {
    override val title = "Secure Endpoints with OAuth 2.0"
    override val url = "https://zalando.github.io/restful-api-guidelines/security/Security.html" +
        "#must-secure-endpoints-with-oauth-20"
    override val violationType = ViolationType.MUST
    override val code = "M010"

    override fun validate(swagger: Swagger): Violation? {
        val hasOAuth = swagger.securityDefinitions.orEmpty().values.any { it.type?.toLowerCase() == "oauth2" }
        val containsHttpScheme = swagger.schemes.orEmpty().contains(Scheme.HTTP)
        return if (!hasOAuth)
            Violation(this, title, "No OAuth2 security definitions found", violationType, url, emptyList())
        else if (containsHttpScheme)
            Violation(this, title, "OAuth2 should be only used together with https", violationType, url, emptyList())
        else
            null
    }
}
