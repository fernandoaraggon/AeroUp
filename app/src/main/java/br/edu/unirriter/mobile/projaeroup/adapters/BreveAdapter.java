package br.edu.unirriter.mobile.projaeroup.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.unirriter.mobile.projaeroup.R;
import br.edu.unirriter.mobile.projaeroup.model.Breve;
import br.edu.unirriter.mobile.projaeroup.ui.rvInterface;

public class BreveAdapter extends RecyclerView.Adapter<BreveAdapter.ViewHolder> {

    private final rvInterface rvInterface;
    private List<Breve> dados;

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

    public BreveAdapter(List<Breve> breve, rvInterface rvInterface) {
        this.dados = breve;
        this.rvInterface = rvInterface;
    }

    @NonNull
    @Override
    public BreveAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup viewGroup;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_breve_layout, parent, false);
        return new ViewHolder(view, rvInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull BreveAdapter.ViewHolder holder, int position) {
        Breve breve = dados.get(position);

        TextView tv = holder.view.findViewById(R.id.tvBreveTitulo);
        tv.setText(breve.getTitulo());

        tv = holder.view.findViewById(R.id.tvBreveEstado);

        tv.setText(breve.getEstado());
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }
}
