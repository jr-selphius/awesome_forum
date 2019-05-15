package jr.selphius.forum.entry_point

import jr.selphius.forum.entry_point.controller.community.{CommunityGetController, CommunityPostController}
import jr.selphius.forum.entry_point.controller.user.{UserGetController, UserPostController}
import jr.selphius.forum.module.community.infrastructure.dependency_injection.CommunityModuleDependencyContainer
import jr.selphius.forum.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer

final class EntryPointDependencyContainer(userDependencies: UserModuleDependencyContainer,
                                          communityDependencies: CommunityModuleDependencyContainer) {
  val userGetController       = new UserGetController(userDependencies.usersSearcher)
  val userPostController      = new UserPostController(userDependencies.userCreator)
  val communityGetController  = new CommunityGetController(communityDependencies.communitiesSearcher)
  val communityPostController = new CommunityPostController(communityDependencies.communitiesCreator)
}
