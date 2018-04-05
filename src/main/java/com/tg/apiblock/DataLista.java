package com.tg.apiblock;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataLista {

	@JsonProperty("profile")
	private Profile profile;
	
	private Boolean 	visible;
	private Boolean 	hidden_by_opening_hours;
	private Boolean 	sms_verification_required;
	private Boolean		require_identification;
	private Boolean 	require_trusted_by_advertiser;
	private Boolean		is_low_risk;
	private Boolean 	trusted_required;
	
	private String 		location_string;
	private String 		countrycode;
	private String 		city;
	private String 		trade_type;
	private String 		online_provider;
	private String 		volume_coefficient_btc;
	private String 		currency;
	private String 		limit_to_fiat_amounts;
	private String 		msg;
	private String 		ad_id;
	private String 		bank_name;
	private String 		atm_model;
	
	private Integer 	min_amount;
	private Integer 	max_amount;
	private Integer	 	max_amount_available;
	private Integer		require_feedback_score;
	private Integer 	lon;
	private Integer 	payment_window_minutes;
	
	
	private Double		require_trade_volume;
	private Double 		temp_price;
	private Double 		temp_price_usd;
	
	private Date 		created_at;

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Boolean getHidden_by_opening_hours() {
		return hidden_by_opening_hours;
	}

	public void setHidden_by_opening_hours(Boolean hidden_by_opening_hours) {
		this.hidden_by_opening_hours = hidden_by_opening_hours;
	}

	public Boolean getSms_verification_required() {
		return sms_verification_required;
	}

	public void setSms_verification_required(Boolean sms_verification_required) {
		this.sms_verification_required = sms_verification_required;
	}

	public Boolean getRequire_identification() {
		return require_identification;
	}

	public void setRequire_identification(Boolean require_identification) {
		this.require_identification = require_identification;
	}

	public Boolean getRequire_trusted_by_advertiser() {
		return require_trusted_by_advertiser;
	}

	public void setRequire_trusted_by_advertiser(Boolean require_trusted_by_advertiser) {
		this.require_trusted_by_advertiser = require_trusted_by_advertiser;
	}

	public Boolean getIs_low_risk() {
		return is_low_risk;
	}

	public void setIs_low_risk(Boolean is_low_risk) {
		this.is_low_risk = is_low_risk;
	}

	public Boolean getTrusted_required() {
		return trusted_required;
	}

	public void setTrusted_required(Boolean trusted_required) {
		this.trusted_required = trusted_required;
	}

	public String getLocation_string() {
		return location_string;
	}

	public void setLocation_string(String location_string) {
		this.location_string = location_string;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getOnline_provider() {
		return online_provider;
	}

	public void setOnline_provider(String online_provider) {
		this.online_provider = online_provider;
	}

	public String getVolume_coefficient_btc() {
		return volume_coefficient_btc;
	}

	public void setVolume_coefficient_btc(String volume_coefficient_btc) {
		this.volume_coefficient_btc = volume_coefficient_btc;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getLimit_to_fiat_amounts() {
		return limit_to_fiat_amounts;
	}

	public void setLimit_to_fiat_amounts(String limit_to_fiat_amounts) {
		this.limit_to_fiat_amounts = limit_to_fiat_amounts;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getAd_id() {
		return ad_id;
	}

	public void setAd_id(String ad_id) {
		this.ad_id = ad_id;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getAtm_model() {
		return atm_model;
	}

	public void setAtm_model(String atm_model) {
		this.atm_model = atm_model;
	}

	public Integer getMin_amount() {
		return min_amount;
	}

	public void setMin_amount(Integer min_amount) {
		this.min_amount = min_amount;
	}

	public Integer getMax_amount() {
		return max_amount;
	}

	public void setMax_amount(Integer max_amount) {
		this.max_amount = max_amount;
	}

	public Integer getMax_amount_available() {
		return max_amount_available;
	}

	public void setMax_amount_available(Integer max_amount_available) {
		this.max_amount_available = max_amount_available;
	}

	public Integer getRequire_feedback_score() {
		return require_feedback_score;
	}

	public void setRequire_feedback_score(Integer require_feedback_score) {
		this.require_feedback_score = require_feedback_score;
	}

	public Integer getLon() {
		return lon;
	}

	public void setLon(Integer lon) {
		this.lon = lon;
	}

	public Integer getPayment_window_minutes() {
		return payment_window_minutes;
	}

	public void setPayment_window_minutes(Integer payment_window_minutes) {
		this.payment_window_minutes = payment_window_minutes;
	}

	public Double getRequire_trade_volume() {
		return require_trade_volume;
	}

	public void setRequire_trade_volume(Double require_trade_volume) {
		this.require_trade_volume = require_trade_volume;
	}

	public Double getTemp_price() {
		return temp_price;
	}

	public void setTemp_price(Double temp_price) {
		this.temp_price = temp_price;
	}

	public Double getTemp_price_usd() {
		return temp_price_usd;
	}

	public void setTemp_price_usd(Double temp_price_usd) {
		this.temp_price_usd = temp_price_usd;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
}
