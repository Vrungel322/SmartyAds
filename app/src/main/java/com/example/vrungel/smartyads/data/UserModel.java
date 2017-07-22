package com.example.vrungel.smartyads.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Vrungel on 22.07.2017.
 */

public class UserModel extends RealmObject {

  @PrimaryKey
  private int id;
  private String name;
  private String surname;

  public UserModel() {
  }

  public UserModel(int id, String name, String surname) {
    this.id = id;
    this.name = name;
    this.surname = surname;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }
}
