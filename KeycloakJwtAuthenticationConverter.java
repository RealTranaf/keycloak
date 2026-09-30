public class KeycloakJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken>{

    private static final String CLIENT_ID = "logging-be";

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {

//        Map<String, Object> realmAccess = jwt.getClaim("realm_access"); // realm roles

        Map<String, Object> resourceAccess = jwt.getClaim("resource_access"); // client roles

        List<String> roles = List.of();

//        if (realmAccess != null) {
//            Object rolesObject = realmAccess.get("roles");
//
//            if (rolesObject instanceof Collection<?> collection) {
//                roles = collection.stream()
//                        .map(Object::toString)
//                        .toList();
//            }
//        }

        if (resourceAccess != null) {
            Object clientObject = resourceAccess.get(CLIENT_ID);
            if (clientObject instanceof Map<?, ?> client) {

                Object rolesObject = client.get("roles");
                if (rolesObject instanceof Collection<?> collection) {
                    roles = collection.stream()
                            .map(Object::toString)
                            .toList();
                }
            }
        }

        List<GrantedAuthority> authorities = roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role)).collect(toList());

        return new JwtAuthenticationToken(jwt, authorities, jwt.getClaimAsString("preferred_username"));
    }
}
