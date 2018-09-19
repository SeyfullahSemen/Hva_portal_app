package app.portal.hva.semen.seyfullah.com.hva_portal_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import app.portal.hva.semen.seyfullah.com.hva_portal_app.Adapters.PortalAdapter;
import app.portal.hva.semen.seyfullah.com.hva_portal_app.Classes.PortalNames;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements PortalAdapter.ReminderClickListener {

    @BindView(R.id.add_page)
    FloatingActionButton mFloatingActionButton;
    @BindView(R.id.recyclerMenu)
    RecyclerView mRecyclerMenu;

    static final int REQUEST_CODE = 1234;

    private List<PortalNames> mPortals = new ArrayList<>();
    private PortalAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mPortals.add(new PortalNames("VLO", "https://vlo.informatica.hva.nl/"));
        mPortals.add(new PortalNames("HVA", "http://www.hva.nl/"));
        mPortals.add(new PortalNames("Studiegids", "https://studiegids.hva.nl//"));

        updateUI();
        mRecyclerMenu.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerMenu.setHasFixedSize(true);
        mAdapter = new PortalAdapter(mPortals, this);
        mRecyclerMenu.setAdapter(mAdapter);

    }

    @OnClick(R.id.add_page)
    public void goToAddPage() {
        startActivityForResult(new Intent(MainActivity.this, AddPortalActivity.class), REQUEST_CODE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void reminderOnClick(int i) {
        Intent intent = new Intent(MainActivity.this, UrlActivity.class);
        intent.putExtra("url", mPortals.get(i).getUrl());
        startActivity(intent);
    }

    private void updateUI() {
        if (mAdapter == null) {
            mAdapter = new PortalAdapter(mPortals, this);
            mRecyclerMenu.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String url = data.getStringExtra("newURL");
                String title = data.getStringExtra("newTitle");

                mPortals.add(new PortalNames(title, url));
                updateUI();

            }
        }
        super.onActivityResult(requestCode, resultCode, data);

    }
}


