import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LawyerAdapter(
    private val context: Context,
    private val lawyers: MutableList<Lawyer>,
    private val listener: OnLawyerClickListener?
) : RecyclerView.Adapter<LawyerAdapter.LawyerViewHolder>() {

    interface OnLawyerClickListener {
        fun onLawyerClick(lawyer: Lawyer, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LawyerViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.lawyer_profile_layout, parent, false)
        return LawyerViewHolder(view)
    }

    override fun onBindViewHolder(holder: LawyerViewHolder, position: Int) {
        val lawyer = lawyers[position]

        holder.nameTextView.text = lawyer.name
        holder.specialtyTextView.text = lawyer.specialty
        holder.ratingBar.rating = lawyer.rating
        holder.experienceTextView.text = "${lawyer.experience} years experience"


        holder.itemView.setOnClickListener {
            listener?.onLawyerClick(lawyer, position)
        }
    }

    override fun getItemCount(): Int {
        return lawyers.size
    }

    fun updateData(newLawyers: List<Lawyer>) {
        lawyers.clear()
        lawyers.addAll(newLawyers)
        notifyDataSetChanged()
    }

    class LawyerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var profileImageView: ImageView = itemView.findViewById(R.id.lawyer_profile_image)
        var nameTextView: TextView = itemView.findViewById(R.id.lawyer_name)
        var specialtyTextView: TextView = itemView.findViewById(R.id.lawyer_specialty)
        var ratingBar: RatingBar = itemView.findViewById(R.id.lawyer_rating)
        var experienceTextView: TextView = itemView.findViewById(R.id.lawyer_experience)
        var contactButton: Button = itemView.findViewById(R.id.contact_button)

        init {
            contactButton.setOnClickListener {

            }
        }
    }

    data class Lawyer(
        val name: String,
        val specialty: String,
        val rating: Float,
        val experience: Int,
        val profileImageUrl: String
    )
}
