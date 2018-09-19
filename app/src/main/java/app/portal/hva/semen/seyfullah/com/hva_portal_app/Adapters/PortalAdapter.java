package app.portal.hva.semen.seyfullah.com.hva_portal_app.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.portal.hva.semen.seyfullah.com.hva_portal_app.Classes.PortalNames;

/*
 * Created by Seyfullah Semen on 17-9-2018.
 */
public class PortalAdapter extends RecyclerView.Adapter<PortalAdapter.ViewHolder> {

    private List<PortalNames> mPortalNames;
    final private ReminderClickListener mReminderClickListener;

    public PortalAdapter(List<PortalNames> mPortalNames, ReminderClickListener mReminderClickListener) {
        this.mReminderClickListener = mReminderClickListener;
        this.mPortalNames = mPortalNames;
    }

    public interface ReminderClickListener {
        void reminderOnClick(int i);
    }

    @NonNull
    @Override
    public PortalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(android.R.layout.simple_list_item_1, null);
// Return a new holder instance
        PortalAdapter.ViewHolder viewHolder = new PortalAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PortalAdapter.ViewHolder holder, int position) {
        PortalNames reminder = mPortalNames.get(position);
        holder.textView.setText(reminder.getPortalName());
    }

    @Override
    public int getItemCount() {
        return mPortalNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textView;

        public ViewHolder(View itemView) {

            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            mReminderClickListener.reminderOnClick(clickedPosition);
        }

    }
}
