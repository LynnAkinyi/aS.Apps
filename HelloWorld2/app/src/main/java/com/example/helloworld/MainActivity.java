
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
    }
}
<RelativeLayout.>
<TextView
 android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:text="@string/hello_world"
         app:layout_constraintBottom_toBottomOf="parent"
         app:layout_constraintLeft_toLeftOf="parent"
         app:layout_constraintRight_toRightOf="parent"
         app:layout_constraintTop_toTopOf="parent" />
</RelativeLayout><RelativeLayout.>
