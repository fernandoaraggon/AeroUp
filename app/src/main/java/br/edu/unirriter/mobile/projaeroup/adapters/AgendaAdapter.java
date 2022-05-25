package br.edu.unirriter.mobile.projaeroup.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.unirriter.mobile.projaeroup.R;
import br.edu.unirriter.mobile.projaeroup.model.Agenda;
import br.edu.unirriter.mobile.projaeroup.model.Breve;
import br.edu.unirriter.mobile.projaeroup.ui.rvInterface;

public class AgendaAdapter extends RecyclerView.Adapter<AgendaAdapter.ViewHolder> {

    private final rvInterface rvInterface;
    private List<Agenda> dados;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ViewHolder(@NonNull View itemView, rvInterface rvInterface) {
            super(itemView);
            this.view = itemView;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(rvInterface != null)
                    {
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION)
                        {
                            rvInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }

    public AgendaAdapter(List<Agenda> agenda, rvInterface rvInterface) {
        this.dados = agenda;
        this.rvInterface = rvInterface;
    }

    @NonNull
    @Override
    public AgendaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup viewGroup;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_agenda_layout, parent, false);
        return new ViewHolder(view, rvInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull AgendaAdapter.ViewHolder holder, int position) {
        Agenda agenda = dados.get(position);

        TextView tv = holder.view.findViewById(R.id.tvHora);
        tv.setText(agenda.getHora());
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }
}
