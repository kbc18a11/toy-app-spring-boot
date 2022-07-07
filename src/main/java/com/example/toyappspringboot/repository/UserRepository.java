package com.example.toyappspringboot.repository;

import java.util.List;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import com.example.toyappspringboot.model.User;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

@Mapper
public interface UserRepository {

  /**
   * レコードの挿入
   * 
   * @param user
   */
  @InsertProvider(UserSqlProvider.class)
  public void create(User user);

  /**
   * レコードをすべて取得
   * 
   * @return
   */
  @SelectProvider(UserSqlProvider.class)
  public List<User> findAll();

  /**
   * レコードの更新
   * 
   * @param user
   */
  @UpdateProvider(UserSqlProvider.class)
  public void update(User user);

  /**
   * SQLの定義
   */
  public class UserSqlProvider implements ProviderMethodResolver {

    /**
     * レコードの挿入
     * 
     * @param user
     * @return
     */
    public String create(User user) {
      return new SQL() {
        {
          INSERT_INTO("users");
          VALUES("name", "#{name}");
          VALUES("email", "#{email}");
        }
      }.toString();
    }

    /**
     * レコードをすべて取得
     * 
     * @return
     */
    public String findAll() {
      return new SQL() {
        {
          SELECT("*");
          FROM("users");
        }
      }.toString();
    }

    /**
     * レコードの更新
     * 
     * @param user
     * @return
     */
    public String update(User user) {
      return new SQL() {
        {
          UPDATE("users");
          SET("name = #{name}");
          SET("email = #{email}");
          WHERE("id = #{id}");
        }
      }.toString();
    }
  }
}
