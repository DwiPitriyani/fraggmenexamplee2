package dwi.polbeng.ac.id.fraggmenexamplee2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dwi.polbeng.ac.id.fraggmenexamplee2.databinding.BookDescriptionBinding

class BookDescription : Fragment() {
    private var _binding: BookDescriptionBinding? = null
    private val binding get() = _binding!!
    private lateinit var arrBookDesc: Array<String>
    private var bookIndex: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BookDescriptionBinding.inflate(inflater, container, false)
        arrBookDesc = resources.getStringArray(R.array.book_descriptions)

        // Restore saved state
        savedInstanceState?.let {
            bookIndex = it.getInt("bookIndex", 0)
        }

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("bookIndex", bookIndex)
        super.onSaveInstanceState(outState)
    }

    fun changeDescription(index: Int) {
        if (index in arrBookDesc.indices) { // Safety check
            bookIndex = index
            binding.tvDescription.text = arrBookDesc[bookIndex]
            println("BOOK INDEX = $bookIndex")
            println(arrBookDesc[bookIndex])
        } else {
            println("Invalid book index: $index")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeDescription(bookIndex)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
