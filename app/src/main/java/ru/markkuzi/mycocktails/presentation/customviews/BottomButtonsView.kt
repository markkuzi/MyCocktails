package ru.markkuzi.mycocktails.presentation.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.markkuzi.mycocktails.R
import ru.markkuzi.mycocktails.databinding.BottomButtonsBinding

class BottomButtonsView(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int,
    defStyleRes: Int,
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes), BottomDoubleButtonsClickListener {

    private val binding by viewBinding(BottomButtonsBinding::bind)
    private var positiveListener: ClickListener = ClickListener.Empty()
    private var negativeListener: ClickListener = ClickListener.Empty()

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(
        context,
        attrs,
        defStyleAttr,
        0,
    )

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context) : this(context, null)

    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.bottom_buttons, this, true)
        initAttributes(attrs, defStyleAttr, defStyleRes)
        initListener()
    }

    private fun initAttributes(attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) {
        if (attrs == null) return
        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.BottomButtonsView,
            defStyleAttr,
            defStyleRes,
        )
        val positiveButtonText =
            typedArray.getString(R.styleable.BottomButtonsView_bottomPositiveButtonText)
        binding.btnPositive.text = positiveButtonText ?: context.getString(R.string.save_button)
        val negativeButtonText =
            typedArray.getString(R.styleable.BottomButtonsView_bottomNegativeButtonText)
        binding.btnNegative.text = negativeButtonText ?: context.getString(R.string.cancel_button)

        typedArray.recycle()
    }

    private fun initListener() {
        binding.btnPositive.setOnClickListener {
            positiveListener.onClickListener()
        }
        binding.btnNegative.setOnClickListener {
            negativeListener.onClickListener()
        }
    }

    override fun setOnPositiveButtonClickListener(block: () -> Unit) {
        positiveListener = ClickListener.Base(block)
    }

    override fun setOnNegativeButtonClickListener(block: () -> Unit) {
        negativeListener = ClickListener.Base(block)
    }
}

interface BottomDoubleButtonsClickListener {

    fun setOnPositiveButtonClickListener(block: () -> Unit)
    fun setOnNegativeButtonClickListener(block: () -> Unit)
}

interface ClickListener {

    fun onClickListener()

    class Empty : ClickListener {
        override fun onClickListener() = Unit
    }

    class Base(private val block: () -> Unit) : ClickListener {
        override fun onClickListener() {
            block.invoke()
        }
    }
}