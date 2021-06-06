package com.rerere.iwara4a.api

import com.rerere.iwara4a.api.service.IwaraParser
import com.rerere.iwara4a.api.service.IwaraService
import com.rerere.iwara4a.model.image.ImageDetail
import com.rerere.iwara4a.model.index.SubscriptionList
import com.rerere.iwara4a.model.session.Session
import com.rerere.iwara4a.model.user.Self

/**
 * IwaraAPI接口的具体实现
 *
 * 内部持有 iwaraParser 和 iwaraService 两个模块, 根据资源是否可以
 * 通过restful api直接访问来选择使用哪个模块获取数据
 */
class IwaraApiImpl(
    private val iwaraParser: IwaraParser,
    private val iwaraService: IwaraService
): IwaraApi {
    override suspend fun login(username: String, password: String): Response<Session> = iwaraParser.login(username, password)
    override suspend fun getSelf(session: Session): Response<Self> = iwaraParser.getSelf(session)
    override suspend fun getSubscriptionList(session: Session, page: Int): Response<SubscriptionList> = iwaraParser.getSubscriptionList(session,page)
    override suspend fun getImagePageDetail(session: Session, imageId: String): Response<ImageDetail> = iwaraParser.getImagePageDetail(session, imageId)
}