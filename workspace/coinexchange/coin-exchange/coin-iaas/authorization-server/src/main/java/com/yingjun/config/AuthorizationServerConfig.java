package com.yingjun.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @ClassName AuthorizationServerConfig
 * @Description
 * @Author 陈英俊
 * @Date 2023/4/3 21:06
 * @Version 1.0
 */
@EnableAuthorizationServer
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private RedisConnectionFactory redisConnectionFactory;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * 添加第三方的客户端
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
				.withClient("coin-api")//第三方客户端的名称
				.secret(passwordEncoder.encode("coin-secret"))//第三方客户端的密钥
				.scopes("all")//第三方客户端的授权范围
				.accessTokenValiditySeconds(3600)//token的有效期
				.refreshTokenValiditySeconds(7 * 3600);//refresh_tokend的有效期
		super.configure(clients);
	}
/**
 * 配置验证管理器，UserDetailService
 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager)
				.userDetailsService(userDetailsService)
				.tokenStore(redisTokenStore());//tokenStore来存储token
		super.configure(endpoints);
	}
	public TokenStore redisTokenStore(){
		return new RedisTokenStore(redisConnectionFactory);
	}
}
