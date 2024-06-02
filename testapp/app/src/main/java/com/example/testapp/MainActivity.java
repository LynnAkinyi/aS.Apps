
package example.helloandroid;
        import android.app.Activity;
        import android.os.Bundle;
        import android.widget.TextView;
public class MainActivity extends AppCompatActivity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("Hello World says Android");
        setContentView(tv);
    } }
