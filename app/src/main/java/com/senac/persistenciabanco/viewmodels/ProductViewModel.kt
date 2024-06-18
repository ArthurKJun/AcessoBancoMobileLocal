package com.senac.persistenciabanco.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.senac.persistenciabanco.dao.ProductDao
import com.senac.persistenciabanco.db.AppDataBase
import com.senac.persistenciabanco.entities.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class ProductViewModelFactory(val db : AppDataBase) : ViewModelProvider.Factory{//tem que criar para usar o db
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(db.productDao) as T
    }
}

class ProductViewModel(val productDao : ProductDao) : ViewModel(){

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

    private fun updateId (id : Long){
        _uiState.update {
            it.copy(id = id)
        }
    }

    fun save(){
        viewModelScope.launch { //cria um processo separado para nao travar o programa tudo que tem acesso ao banco
            val id = productDao.upsert(uiState.value) //insere o produto ou altera se tiver
            if (id > 0){
               updateId(id)
            }
        }
    }

    fun saveNew() {
        save()
        new()
    }

    private fun new() {
        _uiState.update {
            it.copy(id = 0, name = "", description = "", price = 0.00)
        }
    }

}