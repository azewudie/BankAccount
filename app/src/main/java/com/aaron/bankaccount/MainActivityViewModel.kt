package com.aaron.bankaccount

import com.aaron.bankaccount.di.appresources.AppResources
import com.aaron.bankaccount.framework.base.viewModel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel@Inject constructor(private val appResources: AppResources) : BaseViewModel() {
}