package com.eneselibol.projectlibrary.Service;



import com.eneselibol.projectlibrary.Model.Publisher;

import java.util.List;

public interface PublisherService {
    List<Publisher> getAllPublisher();
    void savePublisher(Publisher publisher);
    Publisher getPublisherById(Long id);
    void deletePublisherById(Long id);
}
