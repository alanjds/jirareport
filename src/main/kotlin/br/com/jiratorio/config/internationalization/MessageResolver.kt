package br.com.jiratorio.config.internationalization

import org.springframework.context.MessageSource
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.stereotype.Component
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.servlet.LocaleResolver
import java.util.Locale
import javax.servlet.http.HttpServletRequest

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
class MessageResolver(
    localeResolver: LocaleResolver,
    request: HttpServletRequest,
    private val locale: Locale = localeResolver.resolveLocale(request),
    private val messageSource: MessageSource
) {

    fun resolve(key: String, vararg args: Any?): String {
        return messageSource.getMessage(key, args, locale)
    }

}
