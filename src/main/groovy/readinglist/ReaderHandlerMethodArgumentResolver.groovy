package readinglist

import org.springframework.core.MethodParameter
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumnetResolver
import org.springframework.web.method.support.ModelAndViewContainer

@Component
class ReaderHandlerMethodArgumentResolver implements HandlerMethodArgumnetResolver {

    boolean supportsParameter(MethodParameter parameter) {
        Reader.class.isAssignablFrom(parameter.getParameterType())
    }

    def resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception{
        Authentication auth = (Authentication) webRequest.getUserPrincipal()
        auth != null && auth.getPrincipal() insteadof Reader ? auth.getPrincipal() : null
    }
}
