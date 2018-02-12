package button.panic.cl.panicbutton;

import java.io.IOException;
import java.util.function.Supplier;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by jorgefigueroa on 08-02-18.
 */

public class JwtAuthenticationInterceptor implements Interceptor {
    private Supplier<String> jwtTokenSupplier;

    private JwtAuthenticationInterceptor(Supplier<String> jwtTokenSupplier) {
        this.jwtTokenSupplier = jwtTokenSupplier;
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder builder = original.newBuilder()
                .header("Authorization",
                        String.format("Bearer %s", jwtTokenSupplier.get()));

        Request request = builder.build();
        return chain.proceed(request);
    }
}