
import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BannerAdapter(private val context: Context, private val bannerItems: List<BannerItem>) :
    RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_banner, parent, false)
        return BannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val bannerItem = bannerItems[position]
        holder.titleTextView.text = bannerItem.title
        holder.descriptionTextView.text = bannerItem.description


        holder.itemView.setOnClickListener { v: View? -> }
    }

    override fun getItemCount(): Int {
        return bannerItems.size
    }

    class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var bannerImageView: ImageView = itemView.findViewById<ImageView>(R.id.banner_image)
        var titleTextView: TextView = itemView.findViewById<TextView>(R.id.banner_title)
        var descriptionTextView: TextView = itemView.findViewById<TextView>(R.id.banner_description)
    }

    // Banner item model class
    class BannerItem(// Getters
        val title: String, val description: String, val imageUrl: String
    )
}