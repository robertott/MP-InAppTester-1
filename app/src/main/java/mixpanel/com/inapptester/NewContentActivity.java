package mixpanel.com.inapptester;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

/**
 * Created by drewritter on 4/28/15.
 */
public class NewContentActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getIntent().getAction() == Intent.ACTION_VIEW) {
            Uri data = getIntent().getData();

            if (data != null) {

                // show an alert with the "custom" param
                new AlertDialog.Builder(this)
                        .setTitle("Welcome to New Content!")
                        .setMessage("Found custom param: " +data.getQueryParameter("custom"))
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        }

        // send a Mixpanel event
        MixpanelAPI mMixpanel = MixpanelAPI.getInstance(this, MainActivity.MIXPANEL_API_TOKEN);
        mMixpanel.track("in app activity event", null);
        mMixpanel.flush();
    }
}
