package button.panic.cl.panicbutton.utils;

import android.view.View;

/**
 * Created by jorgefigueroa on 04-02-18.
 */

public class UtilsEnvironment {

    private View mProgressView;
    private View mLoginFormView;

    private void showProgress(boolean show) {
        mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);

        int visibility = show ? View.GONE : View.VISIBLE;

        mLoginFormView.setVisibility(visibility);
    }
}
