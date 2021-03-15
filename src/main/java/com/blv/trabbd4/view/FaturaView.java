package com.blv.trabbd4.view;

import com.blv.trabbd4.repository.FaturaRepository;
import com.blv.trabbd4.repository.ParcelaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FaturaView {
    @Autowired
    FaturaRepository repoFatura;

    @Autowired
    ParcelaRepository repoParcela;

    public FaturaView(){

    }
}
