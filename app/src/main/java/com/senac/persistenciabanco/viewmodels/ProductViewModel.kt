package com.senac.persistenciabanco.viewmodels

import androidx.lifecycle.ViewModel
import com.senac.persistenciabanco.entities.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProductViewModel : ViewModel(){

    private  val _uiState = MutableStateFlow(Product())
    val uiState : StateFlow<Product> = _uiState.asStateFlow()

    fun updateName (name : String){
        _uiState.update {
            it.copy(name = name)
        }
    }

    fun updateDescription (description : String){
        _uiState.update {
            it.copy(description = description)
        }
    }

    fun updatePrice (price : Double){
        _uiState.update {
            it.copy(price = price)
        }
    }

}