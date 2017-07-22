package com.example.vrungel.smartyads.data;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import java.util.List;
import rx.Observable;
import timber.log.Timber;

/**
 * Created by Vrungel on 22.07.2017.
 */

public class DataManager {
  private final Realm mRealm;

  public DataManager(Realm realm) {
    this.mRealm = realm;
  }

  /**
   * Create Dummy data
   * */
  public void fillRealmDB() {
    for (int i = 0; i < 1000; i++) {
      mRealm.beginTransaction();
      UserModel userModel =
          mRealm.createObject(UserModel.class, i);
      userModel.setName("Name_" + i);
      userModel.setSurname("Surname_" + i);
      mRealm.commitTransaction();
    }
  }

  /**
   * Save rx style
   * */
  public <T extends RealmObject> Observable<T> save(T object, Class<T> clazz) {
    Realm realm = mRealm;

    int id;

    try {
      id = realm.where(clazz).max("id").intValue() + 1;
    } catch (Exception e) {
      id = 0;
    }

    ((UserModel) object).setId(id);

    return Observable.just(object)
        .flatMap(t -> Observable.just(t)
            .doOnSubscribe(realm::beginTransaction)
            .doOnUnsubscribe(() -> {
              realm.commitTransaction();
              realm.close();
            })
            .doOnNext(realm::copyToRealm)
        );
  }

  /**
   * Gat all items in db rx style
   * */
  public <T extends RealmObject> Observable<List<T>> getAll (Class<T> clazz) {
    Realm realm = mRealm;

    return Observable.just(clazz)
        .flatMap(t-> Observable.just(t)
            .doOnSubscribe(realm::beginTransaction)
            .doOnUnsubscribe(() -> {
              realm.commitTransaction();
              realm.close();
            })
            .map(type -> realm.where(type).findAll())
        );
  }

  public void clearRealm() {
    RealmResults<UserModel> results = mRealm.where(UserModel.class).findAll();

    // All changes to data must happen in a transaction
    mRealm.beginTransaction();

    // Delete all matches
    results.deleteAllFromRealm();

    mRealm.commitTransaction();
    mRealm.close();
    Timber.e("clearRealm");
  }
}
