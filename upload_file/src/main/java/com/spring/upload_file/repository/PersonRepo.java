package com.spring.upload_file.repository;

import com.spring.upload_file.model.Person;
import com.spring.upload_file.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Optional;
@Repository
public class PersonRepo implements PersonInterface {
    @Autowired
    private StorageService storageService;
    //them tam 2 person
    public PersonRepo() {
                collections.add(new Person(1, "Linda", "female", "1994-10-15", "teacher", "image_o3.jpeg" ));
                collections.add(new Person(2, "John", "male", "1992-11-19", "developer", "imgage_01.jpeg" ));
    }
    //hien thi list person
    @Override
    public List<Person> getAll() {
        return collections;
    }

    //thêm mới person
    @Override
    public void add(Person person, BindingResult result) {
        int id;
        if (collections.isEmpty()) {
            id = 1;
        } else {
            Person lastPerson = (Person) collections.get(collections.size() - 1);
            id = lastPerson.getId() + 1;
        }

        String photo = storageService.uploadFile(person.getPhoto());
        person.setId(id);
        person.setName(person.getName());
        person.setJob(person.getJob());
        person.setGender(person.getGender());
        person.setBirthday(person.getBirthday());
        person.setPhoto(person.getPhoto());
        person.setLinkimg(photo);
        //
        collections.add(person);
    }

    //hiển thị  theo id
    @Override
    public Optional<Person> showById(int id) {

        return collections.stream()
                .filter(p->p.getId() == id).findFirst();
    }

    //hienthi theo ten


    //update
    @Override
    public void update(Person person) {
        //neu ảnh mới update khác link ảnh cữ thì ta ta xoá ảnh cũ đi truoc!
        Optional<Person> personById = showById(person.getId());
        Person personCreated = personById.get();
        String linkImageUpdate = storageService.uploadFile(person.getPhoto());
        if(personCreated.getLinkimg() != linkImageUpdate){
            storageService.deleteFile(personCreated.getLinkimg());
        }

        //update
        showById(person.getId()).ifPresent(personUpdate -> {
            personUpdate.setName(person.getName());
            personUpdate.setJob(person.getJob());
            personUpdate.setGender(person.getGender());
            personUpdate.setBirthday(person.getBirthday());
            personUpdate.setLinkimg(storageService.uploadFile(person.getPhoto()));
        });
    }
    //delete
    @Override
    public void deleteByID(int id) {
        //xoá file image lưu trong thư mục photos
        Optional<Person> personDElete = showById(id);
        Person person = personDElete.get();
        storageService.deleteFile(person.getLinkimg());
        //xoá object
        collections.removeIf(item -> item.getId() == id);

    }

    @Override
    public List<Person> searchByKeyword(String keyword) {
        return null;
    }
}
