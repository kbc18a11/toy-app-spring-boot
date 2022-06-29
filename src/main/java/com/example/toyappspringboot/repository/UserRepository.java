package com.example.toyappspringboot.repository;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
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
  }
}
