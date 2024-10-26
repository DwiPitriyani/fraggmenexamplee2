package dwi.polbeng.ac.id.fraggmenexamplee2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dwi.polbeng.ac.id.fraggmenexamplee2.databinding.BookTitlesBinding

class BookTitle : Fragment(), View.OnClickListener {
    private var _binding: BookTitlesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BookTitlesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.learnAp.setOnClickListener(this)
        binding.learnApWithKotlin.setOnClickListener(this)
        binding.minimumAp.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        var index = -1 // Initialize with an invalid value
        when (v.id) {
            binding.learnAp.id -> {
                index = 0
            }
            binding.learnApWithKotlin.id -> {
                index = 1
            }
            binding.minimumAp.id -> {
                index = 2
            }
        }

        // Notify the activity about the selected book title
        val activity = activity
        if (activity is Coordinator) {
            activity.onBookChanged(index)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}