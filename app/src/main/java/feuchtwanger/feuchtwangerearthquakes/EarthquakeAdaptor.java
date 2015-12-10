package feuchtwanger.feuchtwangerearthquakes;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EarthquakeAdaptor extends RecyclerView.Adapter<EarthquakeViewHolder> {
    private EarthquakeEvent[] earthquakes;

    public EarthquakeAdaptor(EarthquakeEvent[] earthquakes) {
        this.earthquakes = earthquakes;
    }

    @Override
    public EarthquakeViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.earthquake_list_item, parent, false);
        return new EarthquakeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final EarthquakeViewHolder holder, final int position) {
        holder.bind(earthquakes[position].getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, EarthquakeActivity.class);
                intent.putExtra("EARTHQUAKE", earthquakes);
                intent.putExtra("POSITION", position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return earthquakes.length;
    }
}
