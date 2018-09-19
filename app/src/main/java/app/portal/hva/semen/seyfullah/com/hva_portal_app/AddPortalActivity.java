package app.portal.hva.semen.seyfullah.com.hva_portal_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import app.portal.hva.semen.seyfullah.com.hva_portal_app.Classes.PortalNames;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AddPortalActivity extends AppCompatActivity {

    @BindView(R.id.portal_url)
    EditText mTxtUrl;
    @BindView(R.id.portal_name)
    EditText mTxtName;
    @BindView(R.id.main_layout_portal)
    LinearLayout mMainLayoutPortal;
    @BindView(R.id.add_button)
    Button mAddButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_portal);
        ButterKnife.bind(this);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = mTxtUrl.getText().toString();
                String title = mTxtName.getText().toString();

                Intent intent = new Intent(AddPortalActivity.this, MainActivity.class);
                intent.putExtra("newURL", url);
                intent.putExtra("newTitle", title);

                setResult(Activity.RESULT_OK, intent);

                finish();
            }
        });
    }


}

