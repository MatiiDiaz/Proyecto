package com.example.ShopHelp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ShopHelp.R;
import com.example.ShopHelp.VerActivity;
import com.example.ShopHelp.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaProductosAdapter extends RecyclerView.Adapter<ListaProductosAdapter.ProductoViewHolder> {

    ArrayList<Product> listaProductos;
    ArrayList<Product> listaOriginal;

    public ListaProductosAdapter(ArrayList<Product> listaProductos){
        this.listaProductos = listaProductos;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaProductos);
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @SuppressLint("InflateParams") View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_producto, null, false);
        return new ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        //String precio = "Precio: $" + listaProductos.get(position).getAmount_producto();
        String cantidad = "Cant: " + listaProductos.get(position).getQuantity_producto();
        //holder.viewId.setText(listaProductos.get(position).getId_producto());
        holder.viewProducto.setText(listaProductos.get(position).getName_producto());
        //holder.viewPrecio.setText(precio);
        //holder.viewMarca.setText(listaProductos.get(position).getMarca_producto());
        holder.viewCantidad.setText(cantidad);
    }

    public void filtro(String svBuscar){
        int longitud = svBuscar.length();
        if(longitud == 0){
            listaProductos.clear();
            listaProductos.addAll(listaOriginal);
        } else {
            List<Product> coleccion = listaProductos.stream().filter(i -> i.getName_producto().toLowerCase().contains(svBuscar.toLowerCase())).collect(Collectors.toList());
            listaProductos.clear();
            listaProductos.addAll(coleccion);
            /*for (Product c: listaOriginal){
                if (c.getName_producto().toLowerCase().contains(svBuscar.toLowerCase())){
                    listaProductos.add(c);
                }
            }*/
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public class ProductoViewHolder extends RecyclerView.ViewHolder {

        TextView /*viewId,*/ viewProducto, viewPrecio, viewMarca, viewCantidad;

        public ProductoViewHolder(@NonNull View itemView) {
            super(itemView);

            //viewId = itemView.findViewById(R.id.tvId);
            viewProducto = itemView.findViewById(R.id.tvProducto);
            viewPrecio = itemView.findViewById(R.id.tvPrecio);
            viewMarca = itemView.findViewById(R.id.tvMarca);
            viewCantidad = itemView.findViewById(R.id.tvCantidad);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, VerActivity.class);
                    intent.putExtra("ID",listaProductos.get(getAdapterPosition()).getId_producto());
                    context.startActivity(intent);

                }
            });
        }
    }
}
