package com.v5ent.web.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.v5ent.core.result.DataResult;
import com.v5ent.core.result.Result;
import com.v5ent.core.util.StringUtils;
import com.v5ent.web.model.Banner;
import com.v5ent.web.model.Customer;
import com.v5ent.web.model.Investor;
import com.v5ent.web.model.News;
import com.v5ent.web.model.Order;
import com.v5ent.web.model.Plan;
import com.v5ent.web.model.Platform;
import com.v5ent.web.service.BannerService;
import com.v5ent.web.service.CustomerService;
import com.v5ent.web.service.InvestorService;
import com.v5ent.web.service.NewsService;
import com.v5ent.web.service.OrderService;
import com.v5ent.web.service.PlanService;
import com.v5ent.web.service.PlatformService;
import com.v5ent.xoss.util.CodeImage;
import com.v5ent.xoss.util.RequestLogging;

@Controller
// @RequestMapping(value = "api")
@RequestLogging("api请求")
public class BizController {

	@Resource
	private CustomerService customerService;
	@Resource
	private BannerService bannerService;
	@Resource
	private PlatformService platformService;
	@Resource
	private InvestorService investorService;
	@Resource
	private OrderService orderService;
	@Resource
	private PlanService planService;
	@Resource
	private NewsService newsService;

	private static final String ACCOUNT_IS_LOGIN = "ACCOUNT_IS_LOGIN";
	private static final String CUSTOMER_INFO = "customerInfo";

	private Customer token(Model model, HttpSession session) {
		// 登录态
		Customer customerInfo = (Customer) session.getAttribute(CUSTOMER_INFO);
		if (customerInfo != null) {
			model.addAttribute(ACCOUNT_IS_LOGIN, true);
			model.addAttribute(CUSTOMER_INFO, customerInfo);
		} else {
			model.addAttribute(ACCOUNT_IS_LOGIN, false);
		}
		return customerInfo;
	}

	/**
	 * 首页 - PAGE
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, Model model, HttpSession session) {
		token(model, session);
		model.addAttribute("page", 0);
		// banners
		model.addAttribute("banners", bannerService.selectListByCondition(null));
		// 精选三平台
		List<Platform> list = platformService.top3();
		for (Platform p : list) {
			Map m = this.getPlanInfoForPlatform(p.getId());
			p.setMount(m.get("mount").toString());
			p.setMaxIncome(m.get("maxMount").toString());
			p.setMaxYearrate(m.get("maxYear").toString());
		}
		model.addAttribute("top", list);
		// 首页推荐
		list = platformService.hot();
		for (Platform p : list) {
			Map m = this.getPlanInfoForPlatform(p.getId());
			p.setMount(m.get("mount").toString());
			p.setMaxIncome(m.get("maxMount").toString());
			p.setMaxYearrate(m.get("maxYear").toString());
		}
		model.addAttribute("hot", list);
		// 投资排行
		model.addAttribute("hotCustomers", customerService.selectTop10());
		// 资讯：常见问答，官方公告，网贷资讯
		News n = new News();
		n.setType(0);
		model.addAttribute("help", newsService.selectListByCondition(n));
		n.setType(1);
		model.addAttribute("anno", newsService.selectListByCondition(n));
		n.setType(3);
		List<News> news = newsService.selectListByCondition(n);
		if (news.size() > 15) {
			news = news.subList(0, 15);
		}
		model.addAttribute("news", news);
		// 合作伙伴
		model.addAttribute("partner", platformService.hot());
		return "index";
	}

	/***
	 * 搜索平台 - PAGE
	 * 
	 * @param name
	 * @param rcType
	 * @param days
	 * @param request
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("search")
	public String search(String name, Integer type, String rcType, String dmin, String dmax, HttpServletRequest request,
			Model model, HttpSession session) {
		token(model, session);

		Platform t = new Platform();
		if (StringUtils.isNotBlank(name)) {
			t.setName(name);
		}
		if (type != null) {
			t.setAors(type);
			model.addAttribute("page", type);
		}
		if (StringUtils.isNotBlank(rcType)) {
			t.setRcType(rcType);
			model.addAttribute("rcType", rcType);
		}
		t.setStatus(1);
		List<Platform> list = platformService.selectListByCondition(t);
		for (Platform p : list) {
			Map m = this.getPlanInfoForPlatform(p.getId());
			p.setMount(m.get("mount").toString());
			p.setMaxIncome(m.get("maxMount").toString());
			p.setMaxYearrate(m.get("maxYear").toString());
		}
		model.addAttribute("platforms", list);
		return "search";
	}

	/**
	 * newbie - PAGE
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("newbie")
	public String newbie(HttpServletRequest request, Model model, HttpSession session) {
		token(model, session);
		model.addAttribute("page", 3);
		return "newbie";
	}

	/**
	 * account - PAGE
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("account")
	public String account(String key, HttpServletRequest request, Model model, HttpSession session) {
		Customer c = (Customer) session.getAttribute(CUSTOMER_INFO);
		if (c == null) {
			return "redirect:/";
		} else {
			model.addAttribute(ACCOUNT_IS_LOGIN, true);
			model.addAttribute(CUSTOMER_INFO, customerService.selectById(c.getId()));
		}
		if (StringUtils.isBlank(key)) {
			key = "index";
		}
		if ("investor".equals(key)) {
			Investor t = new Investor();
			t.setUserId(c.getUserid());
			model.addAttribute("investors", investorService.selectListByCondition(t));
		}
		if ("order".equals(key)) {
			Order t = new Order();
			t.setUserId(c.getUserid());
			model.addAttribute("orders", orderService.selectListByCondition(t));
		}
		model.addAttribute("key", key);
		return "account";
	}

	/**
	 * 去投资 PAGE
	 * 
	 * @param request
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("a/{pid}")
	public String platform(@PathVariable Long pid, HttpServletRequest request, Model model, HttpSession session) {
		token(model, session);
		model.addAttribute("platform", platformService.selectById(pid));
		Map m = getPlanInfoForPlatform(pid);
		model.addAttribute("planList", m.get("planList"));
		model.addAttribute("mount", m.get("mount"));
		model.addAttribute("maxMount", m.get("maxMount"));
		model.addAttribute("maxYear", m.get("maxYear"));
		model.addAttribute("maxPlan", m.get("maxPlan"));
		return "invest";
	}

	private Plan max(List<Plan> list) {
		Plan temp;
		if (list.isEmpty())
			return null;
		if (list.size() == 1)
			return list.get(0);
		temp = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			Plan p = list.get(i);
			if (Double.parseDouble(temp.getYearfee()) < Double.parseDouble(p.getYearfee())) {
				temp = p;
			}
		}
		return temp;
	}

	/**
	 * 根据pid计算最大返利计划
	 * 
	 * @param pid
	 * @return
	 */
	private Map getPlanInfoForPlatform(Long pid) {
		Plan p = new Plan();
		p.setPid(pid);
		List<Plan> list = planService.selectListByCondition(p);
		Map model = new HashMap();
		model.put("planList", list);
		Double maxMount;
		Double maxYear;
		Plan o = max(list);
		if (o == null) {
			model.put("mount", 0);
			model.put("maxMount", 0);
			model.put("maxYear", 0);
			model.put("maxPlan", "无");
		} else {
			double mount = Double.parseDouble(o.getMount());
			int zhouqi = Integer.parseInt(o.getTouzizhouqi());
			maxMount = (mount * Float.parseFloat(o.getYearate()) / 100 / 365 * zhouqi)
					+ (Double.parseDouble(o.getFanli()) * mount / 100)
					+ (Double.parseDouble(o.getJiangli()) + o.getType() == 1 ? 0: (Double.parseDouble(o.getHongbao()) + Double.parseDouble(o.getOther())));
			// 年化收益率=[（投资内收益 / 本金）/ 投资天数] * 365 ×100%
			maxYear = ((maxMount / mount) / zhouqi) * 365 * 100;
			model.put("mount", o.getMount());
			model.put("maxMount", String.format("%.2f", maxMount));
			model.put("maxYear", String.format("%.2f", maxYear));
			model.put("maxPlan", o.getName());
		}
		return model;
	}

	/**
	 * 资讯详情 PAGE
	 * 
	 * @param request
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("news/{nid}")
	public String news(@PathVariable Long nid, HttpServletRequest request, Model model, HttpSession session) {
		token(model, session);
		model.addAttribute("news", newsService.selectById(nid));
		return "news";
	}

	/**
	 * 资讯列表PAGE
	 * 
	 * @param type
	 * @param request
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping("news")
	public String newsBytype(@RequestParam Integer type, HttpServletRequest request, Model model, HttpSession session) {
		token(model, session);
		News n = new News();
		n.setType(type);
		if (type == 2) {
			Customer current = (Customer) session.getAttribute(CUSTOMER_INFO);
			n.setPerson(current.getUserid());
		}
		model.addAttribute("news", newsService.selectListByCondition(n));
		model.addAttribute("type", type);
		return "news-list";
	}

	/**
	 * 打开第三方注册地址
	 * 
	 * @param pid
	 * @return
	 */
	@RequestMapping("a/{pid}/open")
	public String toInvest(@PathVariable Long pid) {
		Platform p = platformService.selectById(pid);
		return "redirect:" + p.getLink();
	}

	/**
	 * 准备报单JSON
	 * 
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("a/{pid}/join")
	@ResponseBody
	public Map<String, Object> join(@PathVariable Long pid, HttpSession session) {
		Map<String, Object> m = new HashMap<String, Object>();
		Investor t = new Investor();
		Customer current = (Customer) session.getAttribute(CUSTOMER_INFO);
		t.setUserId(current.getUserid());
		m.put("statusCode", 0);
		m.put("requiredImage", false);
		m.put("requiredUsername", false);
		m.put("investorList", investorService.selectListByCondition(t));
		Plan p = new Plan();
		p.setPid(pid);
		m.put("planList", planService.selectListByCondition(p));
		return m;
	}

	/**
	 * 首页banner
	 * 
	 * @return
	 */
	@RequestMapping(value = "/banner", method = RequestMethod.GET)
	@ResponseBody
	public List<Banner> banners() {
		Banner t = new Banner();
		t.setStatus(1);
		return bannerService.selectListByCondition(t);
	}

	/**
	 * 精选平台
	 * 
	 * @return
	 */
	@RequestMapping(value = "/platform/top3", method = RequestMethod.GET)
	@ResponseBody
	public List<Platform> platformTop3() {
		return platformService.top3();
	}

	/**
	 * 首页推荐
	 * 
	 * @return
	 */
	@RequestMapping(value = "/platform/hot", method = RequestMethod.GET)
	@ResponseBody
	public List<Platform> platformHot() {
		return platformService.hot();
	}

	/**
	 * 平台条件查询
	 * 
	 * @return
	 */
	@RequestMapping(value = "/platform", method = RequestMethod.GET)
	@ResponseBody
	@RequestLogging("条件查询")
	public List<Platform> platformA(String type, String rcType, String name) {
		Platform t = new Platform();
		if (StringUtils.isNotBlank(name)) {
			t.setName(name);
		} else {
			if (StringUtils.isNotBlank(type)) {
				if ("S".equals(type)) {
					t.setAors(2);
				} else if ("A".equals(type)) {
					t.setAors(1);
				}
			}
			if (StringUtils.isNotBlank(rcType)) {
				t.setRcType(rcType);
			}
		}
		t.setStatus(1);
		return platformService.selectListByCondition(t);
	}

	/**
	 * 平台详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "/platform/{pid}", method = RequestMethod.GET)
	@ResponseBody
	public Platform platformDetial(@PathVariable Long pid) {
		return platformService.selectById(pid);
	}

	/**
	 * 用户投资排行
	 * 
	 * @return
	 */
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, String>> customers() {
		return customerService.selectTop10();
	}

	// 注册
	@RequestMapping(value = "/account/register_send_code", method = RequestMethod.POST)
	@ResponseBody
	public Result register(String mobile, Model model, HttpServletRequest request, HttpSession session) {
		if (StringUtils.isBlank(mobile)) {
			return new Result(false, "参数错误");
		}
		// 插入
		Customer c = new Customer();
		c.setMobile(mobile);
		if (customerService.selectOne(c) != null) {
			// 已经
			return new Result(false, "已经注册");
		}
		c.setPhone(mobile);
		c.setUserid(StringUtils.getUUID());
		c.setPassword(mobile.substring(5, 11));// 手机号后六位
		c.setCreateTime(new Date());
		c.setMoney(0);
		c.setFreeze(0);
		c.setStatus(1);
		int i = customerService.insert(c);
		if (i != 1) {
			return new Result(false, "用户注册失败");
		}
		// 自动登录
		final Customer authUserInfo = customerService.selectOne(c);
		session.setAttribute(CUSTOMER_INFO, authUserInfo);

		System.out.println("*** Session data ***");
		Enumeration<String> e = session.getAttributeNames();
		while (e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s + " == " + session.getAttribute(s));
		}

		return new Result(true, "自动登录成功");
	}

	@RequestMapping(value = "/captcha/new.json", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> captcha() throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		CodeImage rdnu = CodeImage.Instance();
		String key = rdnu.getKey();
		map.put("key", key);
		map.put("image", "images"+File.separator+key+".jpg");
		return map;
	}

	// 更新昵称
	@RequestMapping(value = "/account/update_user_nickname", method = RequestMethod.POST)
	@ResponseBody
	public Result updateNickname(String nickname, Model model, HttpServletRequest request, HttpSession session) {
		Customer c = token(model, session);
		c = customerService.selectById(c.getId());
		c.setName(nickname);
		customerService.update(c);
		return new Result(true, "更新昵称成功");
	}

	// 更新QQ
	@RequestMapping(value = "/account/update_user_qq", method = RequestMethod.POST)
	@ResponseBody
	public Result updateQQ(String qq, Model model, HttpServletRequest request, HttpSession session) {
		Customer c = token(model, session);
		c = customerService.selectById(c.getId());
		c.setQq(qq);
		customerService.update(c);
		return new Result(true, 0, "更新QQ成功");
	}

	// 更新alipay
	@RequestMapping(value = "/account/update_user_alipay", method = RequestMethod.POST)
	@ResponseBody
	public Result updateAlipay(String alipay, Model model, HttpServletRequest request, HttpSession session) {
		Customer c = token(model, session);
		c = customerService.selectById(c.getId());
		c.setZfb(alipay);
		customerService.update(c);
		return new Result(true, 0, "更新alipay成功");
	}

	// 更新密码
	@RequestMapping(value = "/account/update_user_password", method = RequestMethod.POST)
	@ResponseBody
	public Result updatePassword(String password, String new_password, String new_password_confirm, Model model,
			HttpServletRequest request, HttpSession session) {
		if (StringUtils.isBlank(password) || StringUtils.isBlank(new_password)
				|| StringUtils.isBlank(new_password_confirm) || !new_password.equals(new_password_confirm)) {
			return new Result(false, "参数不合法");
		}
		Customer customerInfo = (Customer) session.getAttribute(CUSTOMER_INFO);
		Customer c = new Customer();
		c.setMobile(customerInfo.getMobile());
		c.setPassword(password);
		c = customerService.selectOne(c);
		if (c == null) {
			return new Result(false, 1, "原始密码不正确");
		}
		c.setPassword(new_password);
		customerService.update(c);
		return new Result(true, 0, "更新密码成功");
	}

	@RequestMapping(value = "/account/login", method = RequestMethod.POST)
	@ResponseBody
	public Result login(String mobile, String password, Model model, HttpServletRequest request, HttpSession session) {
		if (StringUtils.isBlank(mobile) || StringUtils.isBlank(password)) {
			return new Result(false, "参数错误");
		}
		Customer current = (Customer) session.getAttribute(CUSTOMER_INFO);
		if (current != null && mobile.equals(current.getMobile())) {
			// 已经登录
			return new Result(true, "已经登录");
		}
		// 验证成功在Session中保存用户信息
		Customer c = new Customer();
		c.setMobile(mobile);
		c.setPassword(password);
		final Customer authUserInfo = customerService.selectOne(c);
		if (authUserInfo == null) {
			return new Result(false, "用户不存在或者密码错误");
		}
		session.setAttribute(CUSTOMER_INFO, authUserInfo);

		System.out.println("*** Session data ***");
		Enumeration<String> e = session.getAttributeNames();
		while (e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s + " == " + session.getAttribute(s));
		}

		return new Result(true, "登录成功");
	}

	@RequestMapping(value = "/account/investor", method = RequestMethod.POST)
	@ResponseBody
	public DataResult addInvestor(String mobile, String name, Model model, HttpServletRequest request,
			HttpSession session) {
		if (StringUtils.isBlank(mobile) || StringUtils.isBlank(name)) {
			return new DataResult(false, "参数错误");
		}
		Customer current = (Customer) session.getAttribute(CUSTOMER_INFO);
		
		Investor c = new Investor();
		c.setInvestPhone(mobile);
		c.setInvestName(name);
		c.setUserId(current.getUserid());
		if(investorService.selectOne(c)!=null){
			return new DataResult(false, "投资人已经添加过！");
		}
		investorService.insert(c);
		return new DataResult(investorService.selectOne(c));
	}

	@RequestMapping(value = "/account/investor", method = RequestMethod.GET)
	public String delInvestor(@RequestParam Long delid) {
		investorService.delete(delid);
		return "redirect:/account.html?key=investor";
	}

	/**
	 * 交单
	 * 
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/invest/order", method = RequestMethod.POST)
	@ResponseBody
	public Order order(HttpServletRequest request, HttpSession session) throws Exception {
		Customer current = (Customer) session.getAttribute(CUSTOMER_INFO);
		Order o = new Order();
		Long planId = Long.parseLong(request.getParameter("plan"));
		o.setInvestdate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date")));
		Integer amount = Integer.parseInt(request.getParameter("deposit"));
		o.setAmount(amount);
		Integer investId = Integer.parseInt(request.getParameter("investor"));
		o.setInvestId(investId);
		o.setUserId(current.getUserid());
		o.setPlanId(planId);
		o.setName(planService.selectById(planId).toString());
		o.setCreateTime(new Date());
		o.setIsPaid(0);
		orderService.insert(o);
		return orderService.selectOne(o);
	}

	// 登出
	@RequestMapping(value = "/account/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request, HttpSession session) {
		session.removeAttribute(CUSTOMER_INFO);
		Enumeration<String> e = session.getAttributeNames();
		while (e.hasMoreElements()) {
			String s = e.nextElement();
			session.removeAttribute(s);
		}
		session.invalidate();

		return "redirect:/";
	}

}
