package mixpanel.com.inapptester;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.mixpanel.android.mpmetrics.MixpanelAPI;

import java.util.UUID;


public class MainActivity extends ActionBarActivity {

    // your Mixpanel token
    public static final String MIXPANEL_API_TOKEN = "YOUR TOKEN";
    public static final String TEST_DISTINCT_ID = "test_distinct_id_1";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Begin Mixpanel */

        // init Mixpanel
        MixpanelAPI mMixpanel = MixpanelAPI.getInstance(this, MIXPANEL_API_TOKEN);

        // set one People property to create a profile
        mMixpanel.getPeople().set("in app tester", "true");

        // identify to flush the People queue
        mMixpanel.identify(TEST_DISTINCT_ID);
        mMixpanel.getPeople().identify(TEST_DISTINCT_ID);

        // flush the global queue to Mixpanel
        mMixpanel.flush();

        /* End Mixpanel */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
