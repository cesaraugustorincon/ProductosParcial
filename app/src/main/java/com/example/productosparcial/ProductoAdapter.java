package com.example.productosparcial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ProductoAdapter extends BaseAdapter {
    Context context;
    List<Producto> list;

    public ProductoAdapter(Context context, List<Producto> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tvNombre;
        TextView tvCodigo;
        TextView tvValor;
        TextView tvIsExcento;
        TextView tvDescripcion;
        TextView tvCategoria;

        Producto p = list.get(position);

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.listproduct, null);

            tvNombre = convertView.findViewById(R.id.tvNombre);
            tvCodigo = convertView.findViewById(R.id.tvCodigo);
            tvValor = convertView.findViewById(R.id.tvValor);
            tvIsExcento = convertView.findViewById(R.id.tvEsExcento);
            tvDescripcion = convertView.findViewById(R.id.tvDesc);
            tvCategoria = convertView.findViewById(R.id.tvCateg);

            tvNombre.setText(p.getNombre());
            tvCodigo.setText(p.getCodigo());
            tvValor.setText(Integer.toString(p.getValor()));
            tvIsExcento.setText(Boolean.toString(p.isExcento()));
            tvDescripcion.setText(p.getDescripcion());
            tvCategoria.setText(p.getCategoria());
        }

        return convertView;
    }
}
