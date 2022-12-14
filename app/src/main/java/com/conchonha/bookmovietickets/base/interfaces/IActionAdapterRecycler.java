package com.conchonha.bookmovietickets.base.interfaces;

public interface IActionAdapterRecycler <T>{
    void onClickListener(T data);

    void onNavigate(T data);
}
