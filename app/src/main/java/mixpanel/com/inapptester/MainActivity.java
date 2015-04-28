package mixpanel.com.inapptester;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.mixpanel.android.mpmetrics.MixpanelAPI;


public class MainActivity extends ActionBarActivity {

    // your Mixpanel token
    public static final String MIXPANEL_API_TOKEN = "drew-token";
    public static final String TEST_DISTINCT_ID = "inapptester@test.example.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init Mixpanel, then identify
        MixpanelAPI mMixpanel = MixpanelAPI.getInstance(this, MIXPANEL_API_TOKEN);
        mMixpanel.identify(TEST_DISTINCT_ID);
        mMixpanel.getPeople().identify(TEST_DISTINCT_ID);
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
