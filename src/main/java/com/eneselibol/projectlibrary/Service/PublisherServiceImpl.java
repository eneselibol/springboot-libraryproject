package com.eneselibol.projectlibrary.Service;

import com.eneselibol.projectlibrary.Model.Publisher;
import com.eneselibol.projectlibrary.Repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService{

    @Autowired
    PublisherRepository publisherRepository;

    @Override
    public List<Publisher> getAllPublisher() {
        return publisherRepository.findAll();
    }

    @Override
    public void savePublisher(Publisher publisher) {
        this.publisherRepository.save(publisher);
    }

    @Override
    public Publisher getPublisherById(Long id) {
        return publisherRepository.getById(id);
    }

    @Override
    public void deletePublisherById(Long id) {
        this.publisherRepository.deleteById(id);
    }
}
