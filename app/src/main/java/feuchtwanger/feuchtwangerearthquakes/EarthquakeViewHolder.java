package feuchtwanger.feuchtwangerearthquakes;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class EarthquakeViewHolder extends RecyclerView.ViewHolder{
    private TextView title;

    public EarthquakeViewHolder(View itemView){
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
    }

    public void bind(int earthquake){
        title.setText(earthquake);
    }
}
